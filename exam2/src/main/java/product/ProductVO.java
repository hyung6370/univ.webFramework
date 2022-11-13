package product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	int id;
	String writer;
	String title;
	String regdate;
	String body;
	int readcnt;
}
