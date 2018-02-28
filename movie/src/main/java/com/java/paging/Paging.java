package com.java.paging;

public class Paging {
	int maxPost;							// �������� ǥ�õǴ� �Խù� �ִ� ���� �Ǵ� ���� �Խù� ����
	int firstPageNo;						// ù��° ������ ��ȣ
	int prevPageNo;							// ���� ������ ��ȣ
	int startPageNo;						// ���� ������
	int currentPageNo;						// ���� ������ ��ȣ
	int endPageNo;							// �� ������
	int nextPageNo;							// ���� ������ ��ȣ
	int finalPageNo;						// ������ ������ ��ȣ
	int numberOfPost;						// ��ü �Խñ� ��
	int numberOfPage;						// �������� ������ ��
	
	public Paging(int currentPageNo, int maxPost, int numberOfPost) {
		this.currentPageNo = currentPageNo;
		this.numberOfPage = 5;
		// �Խù� �ִ� ������ 0�� �ƴϸ� ���� �Խù� ����, 0�̸� �ִ� 10
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
		// �Խñ��� ������ �޼ҵ� ����
		if(numberOfPost == 0) {
			return;
		}
		
		// ���� �������� 0�̸� ���� ������ 1�� ����
		if(currentPageNo == 0) {
			setCurrentPageNo(1);
		}
		
		// �Խñ��� ������ ������ �Խñ� �ִ� 10���� ����
		if(maxPost == 0) {
			setMaxPost(10);
		}
		
		// ������ ������ �� ���ϴ� ��
		int finalPage = (numberOfPost + (maxPost - 1)) / maxPost;
		
		// ���� �������� ������ ���������� ũ�� ������������ ������������ �� �Է�
		if(currentPageNo > finalPage) {
			setCurrentPageNo(finalPage);
		}
		
		// ���� �������� 0���� ������ ���� ������ 1�� ����
		if(currentPageNo < 0) {
			currentPageNo = 1;
		}
		
		// ���� �������� 1�̸� true �ƴϸ� false
		boolean isNowFirst = currentPageNo == 1 ? true : false;
		
		// ���� �������� ������ �������� ������ true �ƴϸ� false
		boolean isNowFinal = currentPageNo == finalPage ? true : false;
		
		// ���������� �� ���ϴ� ��
		int startPage = ((currentPageNo - 1) / numberOfPage) * numberOfPage + 1;
		
		// �������� �� ���ϴ� ��
		int endPage = startPage + numberOfPage - 1;
		
		// ���������� ������ ���������� ũ�� ���������� ������ ������ �� �Է�
		if(endPage > finalPage) {
			endPage = finalPage;
		}
		
		// ù��° ������ 1�� ����
		setFirstPageNo(1);
		
		// ���� �������� 1�̸� true �ƴϸ� false
		// ���������� ��ȣ ���ϴ� ��
		if(isNowFirst) {
			setPrevPageNo(1);
		} else {
			setPrevPageNo(startPage == 1 ? 1 : startPage - 1);
		}
		
		// ���������� ��ȣ ����
		setStartPageNo(startPage);
		
		// �������� ��ȣ ����
		setEndPageNo(endPage);
		
		// ���� �������� ������ �������� ������ true �ƴϸ� false
		// ���������� ��ȣ ���ϴ� ��
		if(isNowFinal) {
			setNextPageNo(finalPage);
		} else {
			setNextPageNo(((endPage + 1 > finalPage ? finalPage : (endPage + 1))));
		}
		
		// ������ ������ ��ȣ ����
		setFinalPageNo(finalPage);
	}
	
}
