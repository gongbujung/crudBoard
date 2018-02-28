package com.java.paging;

public class Paging {
	int maxPost;							// 페이지당 표시되는 게시물 최대 갯수 또는 현재 게시물 갯수
	int firstPageNo;						// 첫번째 페이지 번호
	int prevPageNo;							// 이전 페이지 번호
	int startPageNo;						// 시작 페이지
	int currentPageNo;						// 현재 페이지 번호
	int endPageNo;							// 끝 페이지
	int nextPageNo;							// 다음 페이지 번호
	int finalPageNo;						// 마지막 페이지 번호
	int numberOfPost;						// 전체 게시글 수
	int numberOfPage;						// 보여지는 페이지 수
	
	public Paging(int currentPageNo, int maxPost, int numberOfPost) {
		this.currentPageNo = currentPageNo;
		this.numberOfPage = 5;
		// 게시물 최대 갯수가 0이 아니면 현재 게시물 갯수, 0이면 최대 10
		this.maxPost = (maxPost != 0) ? maxPost : 10;
		this.numberOfPost = numberOfPost;
	}
	
	public int getMaxPost() {
		return maxPost;
	}
	public void setMaxPost(int maxPost) {
		this.maxPost = maxPost;
	}
	public int getFirstPageNo() {
		return firstPageNo;
	}
	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}
	public int getPrevPageNo() {
		return prevPageNo;
	}
	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	public int getNextPageNo() {
		return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	public int getFinalPageNo() {
		return finalPageNo;
	}
	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}
	public int getNumberOfPost() {
		return numberOfPost;
	}
	public void setNumberOfPost(int numberOfPost) {
		this.numberOfPost = numberOfPost;
	}
	public int getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	
	public void makePaging() {
		// 게시글이 없으면 메소드 종료
		if(numberOfPost == 0) {
			return;
		}
		
		// 현재 페이지가 0이면 현재 페이지 1로 설정
		if(currentPageNo == 0) {
			setCurrentPageNo(1);
		}
		
		// 게시글이 없으면 페이지 게시글 최대 10으로 설정
		if(maxPost == 0) {
			setMaxPost(10);
		}
		
		// 마지막 페이지 값 구하는 식
		int finalPage = (numberOfPost + (maxPost - 1)) / maxPost;
		
		// 현재 페이지가 마지막 페이지보다 크면 현재페이지에 마지막페이지 값 입력
		if(currentPageNo > finalPage) {
			setCurrentPageNo(finalPage);
		}
		
		// 현재 페이지가 0보다 작으면 현재 페이지 1로 설정
		if(currentPageNo < 0) {
			currentPageNo = 1;
		}
		
		// 현재 페이지가 1이면 true 아니면 false
		boolean isNowFirst = currentPageNo == 1 ? true : false;
		
		// 현재 페이지가 마지막 페이지와 같으면 true 아니면 false
		boolean isNowFinal = currentPageNo == finalPage ? true : false;
		
		// 시작페이지 값 구하는 식
		int startPage = ((currentPageNo - 1) / numberOfPage) * numberOfPage + 1;
		
		// 끝페이지 값 구하는 식
		int endPage = startPage + numberOfPage - 1;
		
		// 끝페이지가 마지막 페이지보다 크면 끝페이지에 마지막 페이지 값 입력
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		
		// 첫번째 페이지 1로 설정
		setFirstPageNo(1);
		
		// 현재 페이지가 1이면 true 아니면 false
		// 이전페이지 번호 구하는 식
		if(isNowFirst) {
			setPrevPageNo(1);
		} else {
			setPrevPageNo(startPage == 1 ? 1 : startPage - 1);
		}
		
		// 시작페이지 번호 설정
		setStartPageNo(startPage);
		
		// 끝페이지 번호 설정
		setEndPageNo(endPage);
		
		// 현재 페이지가 마지막 페이지와 같으면 true 아니면 false
		// 다음페이지 번호 구하는 식
		if(isNowFinal) {
			setNextPageNo(finalPage);
		} else {
			setNextPageNo(((endPage + 1 > finalPage ? finalPage : (endPage + 1))));
		}
		
		// 마지막 페이지 번호 설정
		setFinalPageNo(finalPage);
	}
	
}
