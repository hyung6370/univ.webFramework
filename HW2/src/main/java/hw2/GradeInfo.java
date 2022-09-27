package hw2;

public class GradeInfo {
	private int id;
	private String name;
	private int mexam;
	private int fexam;
	private int report;
	private int check;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMexam() {
		return mexam;
	}

	public void setMexam(int mexam) {
		this.mexam = mexam;
	}

	public int getFexam() {
		return fexam;
	}

	public void setFexam(int fexam) {
		this.fexam = fexam;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public boolean totalScore() {
		if (mexam + fexam + report + check >= 60)
			return true;
		else
			return false;
	}

}
