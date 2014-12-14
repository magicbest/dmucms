package com.safewind.dmucms.domain;

public class Pager
{
	private int totalRows;      // 总行数
	private int pageSize = 8;  // 每页显示的行数
	private int currentPage ;  // 当前页号
	private int totalPages;   // 总页数
	private int startRow;    // 当前页在数据库中的起始行
	private int endRow;     // 结束行 此为oracle查询需要增加

	public Pager(int _totalRows , int _currentPage)
	{
		totalRows   =  _totalRows ;
		currentPage = _currentPage ;
		totalPages = (totalRows  +  pageSize  - 1 )/ pageSize;
		startRow = (currentPage - 1 ) *  pageSize ;
		endRow =  startRow + pageSize ;
	}

	public int getTotalRows()
	{
		return totalRows;
	}

	public void setTotalRows(int totalRows)
	{
		this.totalRows = totalRows;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getTotalPages()
	{
		return totalPages;
	}

	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}

	public int getStartRow()
	{
		return startRow;
	}

	public void setStartRow(int startRow)
	{
		this.startRow = startRow;
	}

	public int getEndRow()
	{
		return endRow;
	}

	public void setEndRow(int endRow)
	{
		this.endRow = endRow;
	}

}
