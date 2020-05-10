package infocare.entity;

import com.alibaba.fastjson.annotation.JSONType;

import java.sql.Date;
import java.util.Objects;


@JSONType
public class Tip {
	private Integer id;
	private Date start;
	private Date end;
	private String content;

	public Tip() {
	}

	public Tip(Date start, Date end, String content) {
		this.id = null;
		this.start = start;
		this.end = end;
		this.content = content;
	}

	public Tip(int id, Date start, Date end, String content) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tip)) return false;
		Tip tip = (Tip) o;
		return start.equals(tip.start) &&
			end.equals(tip.end);
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

	@Override
	public String toString() {
		return "Tip{" +
			"start=" + start +
			", end=" + end +
			", content='" + content + '\'' +
			'}';
	}
}
