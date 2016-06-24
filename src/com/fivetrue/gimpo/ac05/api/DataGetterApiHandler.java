package com.fivetrue.gimpo.ac05.api;


import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.manager.NotificationDataDBManager;
import com.fivetrue.gimpo.ac05.manager.PageDataDBManager;
import com.fivetrue.gimpo.ac05.manager.TownDataDBManager;
import com.fivetrue.gimpo.ac05.vo.MainDataEntry;
import com.fivetrue.gimpo.ac05.vo.NotificationData;
import com.fivetrue.gimpo.ac05.vo.PageData;
import com.fivetrue.gimpo.ac05.vo.PageData.PageType;
import com.fivetrue.gimpo.ac05.vo.TownData;
import com.fivetrue.gimpo.ac05.vo.TownDataEntry;
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
	
	public void getTownData(){
		
	}
	
	public void getNoticeData(){
		if(checkRequestValidation()){
			Result result = new Result();
			String query = NotificationDataDBManager.getInstance().getSelectQuery(null, null) + " ORDER BY createTime DESC LIMIT 10";
			ArrayList<NotificationData> notidata = NotificationDataDBManager.getInstance().rawQuery(query);
			result.setResult(notidata);
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.makeResponseTime();
			writeObject(result);
		}
	}
	
	public void getMainData(){
		if(checkRequestValidation()){
			String type = getParameter("type");
			Result result = new Result();
			
			MainDataEntry entry = new MainDataEntry();
			/**
			 * 공지사항 
			 */
			String[] selection = {
					"title",
					"message",
					"uri",
					"imageUrl",
					"createTime",
					"authorNickname",
					"authorEmail",
			};
			String query = NotificationDataDBManager.getInstance().getSelectQuery(selection, "type=1") + " ORDER BY createTime DESC LIMIT 10";
			ArrayList<NotificationData> notidata = NotificationDataDBManager.getInstance().rawQuery(query);
			entry.setNotices(notidata);
			/**
			 * 마을 데이터 
			 */
			ArrayList<TownData> town = TownDataDBManager.getInstance().getSelectQueryData(null, null);
			if(town == null || town.size() <= 0){
				resetTownData();
			}
			town = TownDataDBManager.getInstance().getSelectQueryData(null, null);
			TownDataEntry townEntry= new TownDataEntry();
			townEntry.setTitle("최근 우리동네 소식");
			townEntry.setCount(town.size());
			townEntry.setDescription("김포 구래동 최근 소식 정보입니다. 해당 정보는 하루에 한번 업데이트 됩니다.");
			townEntry.setList(town);
			townEntry.setTitleColor("#FFFFFFFF");
			townEntry.setTitleBgColor("#FF3887fa");
			townEntry.setContentColor("#FFFFFFFF");
			townEntry.setContentBgColor("#FF3887fa");
			entry.setTown(townEntry);
			
			/**
			 * 저널 및 뉴스 데이터 
			 */
			ArrayList<PageData> pageData = getPageDatas(type);
			if(pageData == null || pageData.size() <= 0){
				resetPageData();
			}
			pageData = getPageDatas(type);
			entry.setPages(pageData);
			
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.setResult(entry);
			result.makeResponseTime();
			writeObject(result);
		}
	}
	
	private ArrayList<PageData> getPageDatas(String type){
		ArrayList<PageData> datas = PageDataDBManager.getInstance().getPageData(type);
		return datas;
	}
	
	public void resetData(){
		if(checkRequestValidation()){
			Result result = new Result();
			int count = resetPageData();
			count += resetTownData();
			result.makeResponseTime();
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.setResult(count);
			writeObject(count);
		}
	}

	private int resetPageData(){
		ArrayList<PageData> pages = new ArrayList<>();
		pages.add(new PageData("최근 김포 저널", "http://www.gimpojn.com/rss/clickTop.xml"
//				,"#FFecedf5", "#FF87b4f6", "#FFecedf5", "#FF87b4f6"
				,"#FFFFFFFF", "#FF87b4f6", "#FFFFFFFF", "#FF87b4f6"
				, "김포 저널에 업로드되는 정보입니다. 3시간 마다 업데이트 됩니다.", PageType.Journal.name()));
		pages.add(new PageData("최근 김포 뉴스", "http://www.igimpo.com/rss/clickTop.xml"
//				,"#FFecedf5", "#FFFFA900", "#FFecedf5", "#FFFFA900"
				,"#FFFFFFFF", "#FF3887fa", "#FFFFFFFF", "#FF3887fa"
				, "김포 뉴스에 업로드되는 정보입니다. 1시간 마다 업데이트 됩니다.", PageType.News.name()));

		PageDataDBManager.getInstance().drop();
		PageDataDBManager.getInstance().create();
		if(pages != null && pages.size() > 0){
			for(PageData page : pages){
				PageDataDBManager.getInstance().insertObject(page);
			}
		}
		return pages.size();
	}
	
	private int resetTownData(){
		ArrayList<TownData> datas = getTownNews();
		TownDataDBManager.getInstance().drop();
		TownDataDBManager.getInstance().create();
		if(datas != null){
			for(TownData page : datas){
				TownDataDBManager.getInstance().insertObject(page);
			}
		}
		return datas.size();
	}
	
	private ArrayList<TownData> getTownNews(){
		String api = GIMPO_LOCAL_NOTICE_HOST + GIMPO_LOCAL_NOTICE_BOARD;
		Pair<String, String>[] header = new Pair[1];
		header[0] = new Pair<String, String>("Content-Type", "text/html; charset=UTF-8");
		String response = requestApi(api, "GET", true, header, "");

		String[] splits = response.split("<a href=");
		ArrayList<TownData> pages = new ArrayList<>();
		for(String data : splits){
			if(data.contains("view.do")){
				data = data.replaceAll("\"", "");
				int startTokenIndex = data.indexOf(">");
				int endTokenIndex = data.indexOf("</a>");
				String url = data.substring(0, startTokenIndex);
				String title = data.substring(startTokenIndex + 1, endTokenIndex);
				url = GIMPO_LOCAL_NOTICE_HOST + url;
				TownData page = new TownData();

				page.setUrl(url);
				page.setTitle(title);


				String subResponse = requestApi(url, "GET", true, header, "");
				String authorStartToken = "<th scope=\"row\">작성자</th>";
				String authorSecondToken = "<td>";
				String authorEndToken = "</td>";
				
				subResponse = subResponse.substring(subResponse.indexOf(authorStartToken) + authorStartToken.length());
				subResponse = subResponse.substring(subResponse.indexOf(authorSecondToken) + authorSecondToken.length());
				
				String author = subResponse.substring(0, subResponse.indexOf(authorEndToken));
				
				String dateStartToken = "<td>";
				String dateEndToken = "</td>";
				
				subResponse = subResponse.substring(subResponse.indexOf(dateStartToken) + dateStartToken.length());
				
				String date = subResponse.substring(0, subResponse.indexOf(dateEndToken));
				
				String contentStartToken = "<td colspan=\"4\" class=\"bbs_con\">";
				String contentEndToken = "</td>";
				int startSubTokenIndex = subResponse.indexOf(contentStartToken) + contentStartToken.length();
				String subChild = subResponse.substring(startSubTokenIndex);
				int endSubTokenIndex = subChild.indexOf(contentEndToken) + contentEndToken.length();
				String htmlContent = subChild.substring(0, endSubTokenIndex);

				htmlContent = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" + htmlContent.trim();
				page.setContent(htmlContent);
				page.setAuthor(author);
				page.setDate(date);
				pages.add(page);
			}
		}
		return pages;
		
	}
	
	
//	private ArrayList<PageData> getRssFeed(String url, PageType type){
//		ArrayList<PageData> pages = new ArrayList<>();
//		if(url != null){
//			RSSFeedParser parser = new RSSFeedParser(url);
//		    Feed feed = parser.readFeed();
//		    for (FeedMessage message : feed.getMessages()) {
//		    	PageData data = new PageData();
//		    	data.setPageTitle(message.getTitle());
//		    	data.setPageUrl(message.getLink());
//		    	data.setPageType(type.name());
//		    	data.setPageDate(message.getPubDate());
//		    	pages.add(data);
//		    }
//		}
//		return pages;
//	}
	
//	private ArrayList<PageData>  getJournalFeed(){
//		String apiFeed = "http://www.gimpojn.com/rss/clickTop.xml";
//		
//		ArrayList<PageData> pages = new ArrayList<>();
//		RSSFeedParser parser = new RSSFeedParser(apiFeed);
//	    Feed feed = parser.readFeed();
//	    for (FeedMessage message : feed.getMessages()) {
//	    	PageData data = new PageData();
//	    	data.setPageTitle(message.getTitle());
//	    	data.setPageContent(message.getDescription());
//	    	data.setPageAuthor(message.getAuthor());
//	    	data.setPageUrl(message.getLink());
//	    	data.setPageType(PageType.Journal.name());
//	    	data.setPageDate(message.getPubDate());
//	    	pages.add(data);
//	    }
//		return pages;
//		
//	}
//	
//	private ArrayList<PageData>  getNewsFeed(){
//		String apiFeed = "http://www.igimpo.com/rss/clickTop.xml";
//		
//		ArrayList<PageData> pages = new ArrayList<>();
//		RSSFeedParser parser = new RSSFeedParser(apiFeed);
//	    Feed feed = parser.readFeed();
//	    for (FeedMessage message : feed.getMessages()) {
//	    	PageData data = new PageData();
//	    	data.setPageTitle(message.getTitle());
//	    	data.setPageContent(message.getDescription());
//	    	data.setPageAuthor(message.getAuthor());
//	    	data.setPageUrl(message.getLink());
//	    	data.setPageType(PageType.News.name());
//	    	pages.add(data);
//	    }
//		return pages;
//		
//	}
}
