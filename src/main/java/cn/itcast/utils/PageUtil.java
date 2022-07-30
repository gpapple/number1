package cn.itcast.utils;

import java.util.List;


public class PageUtil {
	private List list;
	private Integer pageSize = 2;
	private Integer pageNum;
	private Integer startIndex;
	private Integer totalRecords;
	private Integer totalPage;
	private Integer firstPage;
	private Integer lastPage;
	private Integer previousPage;
	private Integer nextPage;
	private String pageRequest;
	private String likename;
	
	private int startPage;
	private int endPage;
	
	
	public PageUtil(int totalRecords,int pageNum) {
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		
		this.firstPage = 1;
		
		startIndex = (pageNum -1) * pageSize;
				
		totalPage = totalRecords%pageSize==0? totalRecords/pageSize: totalRecords/pageSize+1;
		
		if(totalPage<=9){
			startPage = 1;
			endPage = totalPage;
		}else {
			startPage = pageNum-4;
			endPage = endPage +4;
			
			if (startPage < 1) {
				startPage = 1;
				endPage = 9;
			}
			
			if (endPage > totalPage) {
				endPage = totalPage;
				startPage = totalPage-8;
			}
		}
		
		
		if (this.pageNum >1) {
			this.previousPage = this.pageNum - 1;
		}else{
			this.previousPage = this.firstPage;
		}
		
		this.lastPage = this.totalPage;
		
		if (this.pageNum < this.lastPage) {
			this.nextPage = this.pageNum + 1;
		}else{
			this.nextPage = this.lastPage;
		}
	}
	
	public PageUtil() {
	
	}
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}




	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public String getPageRequest() {
		return pageRequest;
	}
	public void setPageRequest(String pageRequest) {
		this.pageRequest = pageRequest;
	}
	public String getLikename() {
		return likename;
	}
	public void setLikename(String likename) {
		this.likename = likename;
	}
	
	
	
	@Override
	public String toString() {
		return "PageUtil [list=" + list + ", pageSize=" + pageSize + ", pageNum=" + pageNum + ", startIndex="
				+ startIndex + ", totalRecords=" + totalRecords + ", totalPage=" + totalPage + ", firstPage="
				+ firstPage + ", lastPage=" + lastPage + ", previousPage=" + previousPage + ", nextPage=" + nextPage
				+ ", pageRequest=" + pageRequest + ", likename=" + likename + "]";
	}
	
	
}
