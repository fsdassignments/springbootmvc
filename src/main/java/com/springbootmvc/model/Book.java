package com.springbootmvc.model;
// Generated Aug 16, 2019 11:57:45 PM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Book generated by hbm2java
 */

@Entity
@Table(name = "book", catalog = "fsd_assignments")
public class Book implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -2674212590612711281L;
	private Long bookId;
	private Subject subject;
	private String title;
	private double price;
	private int volume;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;

	public Book() {
	}

	public Book(Subject subject, String title, double price, int volume, Date publishDate) {
		this.subject = subject;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bookId", unique = true, nullable = false)
	public Long getBookId() {
		return this.bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "subjectId")
	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Column(name = "title", nullable = false, length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "volume", nullable = false)
	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "publishDate", nullable = false, length = 10)
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, price, publishDate, title, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookId, other.bookId)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publishDate, other.publishDate) && Objects.equals(title, other.title)
				&& volume == other.volume;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}

}
