package com.java.jsoup;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MovieJsoup {

	public ArrayList<Object> WebScraping() {
		
		Document doc = null;
		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/?ft=0").get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> currentMovieImage = new ArrayList<String>();
		ArrayList<String> currentMovieTitle = new ArrayList<String>();
		ArrayList<String> currentMovieInfo = new ArrayList<String>();
		
		try {
			for(int i=0; i<7; i++) {
				// 이미지 가져오기
				Element image = doc.select(".thumb-image > img").get(i);
				currentMovieImage.add(image.attr("src"));
				// 제목 가져오기
				Element title = doc.select(".box-contents > a").get(i);
				currentMovieTitle.add(title.text());
				// 개봉 날짜 가져오기
				Element Info = doc.select(".txt-Info").get(i);
				currentMovieInfo.add(Info.text());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ArrayList<Object> currentMovie = new ArrayList<Object>();
		currentMovie.add(currentMovieTitle);
		currentMovie.add(currentMovieImage);
		currentMovie.add(currentMovieInfo);
		
		return currentMovie;
	}
}
