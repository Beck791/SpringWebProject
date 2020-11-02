package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "bookDetail")
public class BookDetail {
	private int id;
	private String publisher;
	private String publisheraddress;
	private Book book;
	
	/*?��??�方式是ForeignKey ??��?��?�數對�?�book table*/
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "book"))
	@Id
	@GeneratedValue(generator = "generator") //?��??��?��?��?��?�GenericGenerator
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "PUBLISHER")
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "PUBLISHERADDRESS")
	public String getPublisheraddress() {
		return publisheraddress;
	}

	public void setPublisheraddress(String publisheraddress) {
		this.publisheraddress = publisheraddress;
	}
	/*??�聯?�是1�?1，�?��?�book table??�PrimaryKey*/
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
