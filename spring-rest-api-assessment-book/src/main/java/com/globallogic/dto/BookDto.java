/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	
	private Long bookId;
	private String title;
	private String author;
	private String category;
	private Double price;

}
