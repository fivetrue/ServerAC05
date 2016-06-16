package com.fivetrue.gimpo.ac05.api;


import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.manager.PageDataDBManager;
import com.fivetrue.gimpo.ac05.vo.PageData;
import com.fivetrue.gimpo.ac05.vo.PageData.PageType;
import com.fivetrue.gimpo.ac05.vo.PageDataEntry;
import com.fivetrue.rss.Feed;
import com.fivetrue.rss.FeedMessage;
import com.fivetrue.rss.RSSFeedParser;

import javafx.util.Pair;


public class DataGetterApiHandler extends ProjectCheckApiHandler{

	private static final String GIMPO_LOCAL_NOTICE_HOST = "http://gr.gimpo.go.kr/gurae/bbs/CM5311/";
	private static final String GIMPO_LOCAL_NOTICE_BOARD = "list.do?menu_cd=102406&pageIndex=1";
	//	private static final String GIMPO_LOCAL_NOTICE_BOARD = "list.do?menu_cd=102406&pageIndex=1";


	private static final String TAG = "DataGetterApiHandler";

	public DataGetterApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}
	
	public void getPageDatas(){
		if(checkRequestValidation()){
			String type = getParameter("type");
			Result result = new Result();
			ArrayList<PageData> datas = PageDataDBManager.getInstance().getPageData(type);
			
			ArrayList<PageData> town = new ArrayList<>();
			ArrayList<PageData> journal = new ArrayList<>();
			ArrayList<PageData> news = new ArrayList<>();
			for(PageData page : datas){
				switch(page.getType()){
				case Town:
					town.add(page);
					break;
				case Journal:
					journal.add(page);
					break;
				case News:
					news.add(page);
					break;
				}
			}
			
			ArrayList<PageDataEntry> entries = new ArrayList<>();
//			entries.add(makePageDataEntry("최근 우리동네 소식", town, "#FFecedf5", "#FF3887fa", "#FFecedf5", "#66ecedf5"));
//			entries.add(makePageDataEntry("최근 김포 저널", journal, "#FFecedf5", "#FFFFA900", "#FFecedf5", "#66FFA900" ));
//			entries.add(makePageDataEntry("최근 김포 뉴스", news, "#FFecedf5", "#FFD48C00", "#FFecedf5", "#66D48C00" ));
			entries.add(makePageDataEntry("최근 우리동네 소식", town, "#FFFFFFFF", "#FF3887fa", "#FFFFFFFF", "#FF3887fa"));
			entries.add(makePageDataEntry("최근 김포 저널", journal, "#FFFFFFFF", "#FF87b4f6", "#FFFFFFFF", "#FF87b4f6" ));
			entries.add(makePageDataEntry("최근 김포 뉴스", news, "#FFFFFFFF", "#FFD48C00", "#FFFFFFFF", "#FFD48C00" ));
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.makeResponseTime();
			result.setResult(entries);
			writeObject(result);
		}
	}
	
	private PageDataEntry makePageDataEntry(String title, ArrayList<PageData> data, String titleColor, String titlebgColor
			, String contentColor, String contentBgColor){
		PageDataEntry entry = new PageDataEntry();
		entry.setDataTitle(title);
		entry.setPages(data);
		entry.setCount(data.size());
		entry.setTitleColor(titleColor);
		entry.setTitleBgColor(titlebgColor);
		entry.setContentColor(contentColor);
		entry.setContentBgColor(contentBgColor);
		return entry;
	}


	public void gettingDatas(){
		Result result = new Result();
		ArrayList<PageData> pages = new ArrayList<>();
		pages.addAll(getTownNews());
		pages.addAll(getJournalFeed());
		pages.addAll(getNewsFeed());
		
		PageDataDBManager.getInstance().drop();
		PageDataDBManager.getInstance().create();
		if(pages != null && pages.size() > 0){
			for(PageData page : pages){
				PageDataDBManager.getInstance().insertObject(page);
			}
		}
		result.setErrorCode(Result.ERROR_CODE_OK);
		result.setResult(pages.size());
		result.makeResponseTime();
		writeObject(result);
	}
	
	private ArrayList<PageData> getTownNews(){
		String api = GIMPO_LOCAL_NOTICE_HOST + GIMPO_LOCAL_NOTICE_BOARD;
		Pair<String, String>[] header = new Pair[1];
//		header[0] = new Pair<String, String>("Content-Type", "text/html; charset=UTF-8");
		String response = requestApi(api, "GET", true, header, null);

		String[] splits = response.split("<a href=");
		ArrayList<PageData> pages = new ArrayList<>();
		for(String data : splits){
			if(data.contains("view.do")){
				data = data.replaceAll("\"", "");
				int startTokenIndex = data.indexOf(">");
				int endTokenIndex = data.indexOf("</a>");
				String url = data.substring(0, startTokenIndex);
				String title = data.substring(startTokenIndex + 1, endTokenIndex);
				url = GIMPO_LOCAL_NOTICE_HOST + url;
				PageData page = new PageData();

				page.setPageUrl(url);
				page.setPageTitle(title);


				String subResponse = requestApi(url, "GET", true, header, null);
				String startToken = "<td colspan=\"4\" class=\"bbs_con\">";
				String endToken = "</td>";
				int startSubTokenIndex = subResponse.indexOf(startToken) + startToken.length();
				String subChild = subResponse.substring(startSubTokenIndex);
				int endSubTokenIndex = subChild.indexOf(endToken) + endToken.length();
				String htmlContent = subChild.substring(0, endSubTokenIndex);

//				htmlContent = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + htmlContent.trim();
				htmlContent = htmlContent.trim();
				page.setPageContent(htmlContent);
				page.setPageType(PageType.Town.name());
				pages.add(page);
			}
		}
		return pages;
		
	}
	
	private ArrayList<PageData>  getJournalFeed(){
		String apiFeed = "http://www.gimpojn.com/rss/clickTop.xml";
		
		ArrayList<PageData> pages = new ArrayList<>();
		RSSFeedParser parser = new RSSFeedParser(apiFeed);
	    Feed feed = parser.readFeed();
	    for (FeedMessage message : feed.getMessages()) {
	    	PageData data = new PageData();
	    	data.setPageTitle(message.getTitle());
	    	data.setPageContent(message.getDescription());
	    	data.setPageAuthor(message.getAuthor());
	    	data.setPageUrl(message.getLink());
	    	data.setPageType(PageType.Journal.name());
	    	pages.add(data);
	    }
		return pages;
		
	}
	
	private ArrayList<PageData>  getNewsFeed(){
		String apiFeed = "http://www.igimpo.com/rss/clickTop.xml";
		
		ArrayList<PageData> pages = new ArrayList<>();
		RSSFeedParser parser = new RSSFeedParser(apiFeed);
	    Feed feed = parser.readFeed();
	    for (FeedMessage message : feed.getMessages()) {
	    	PageData data = new PageData();
	    	data.setPageTitle(message.getTitle());
	    	data.setPageContent(message.getDescription());
	    	data.setPageAuthor(message.getAuthor());
	    	data.setPageUrl(message.getLink());
	    	data.setPageType(PageType.News.name());
	    	pages.add(data);
	    }
		return pages;
		
	}
}
