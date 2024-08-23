package com.globallogic.book.dto;

public class BookDto {

	private Long id;
	private String bookName;
	private double bookPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

}
