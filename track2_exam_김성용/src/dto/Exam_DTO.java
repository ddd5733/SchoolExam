package dto;

public class Exam_DTO {
	public Exam_DTO(String exam_number, String title, String content, String reg_date, String start_date,
			String end_date, String name, int hit, int likecount) {
		super();
		this.exam_number = exam_number;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.name = name;
		this.hit = hit;
		this.likecount = likecount;
	}
	String exam_number, title, content, reg_date, start_date,
	end_date,name;
	int hit, likecount;
	public Exam_DTO(){}
	
	public String getExam_number() {
		return exam_number;
	}
	public void setExam_number(String exam_number) {
		this.exam_number = exam_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
}