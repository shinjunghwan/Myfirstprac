// BoardDTO.java

package model.com.tistory.gangzzang;

import java.util.Date;

public class BoardDTO {
	private int no; // 湲�踰덊샇
	private String id; // �븘�씠�뵒
	private String pwd; // 鍮꾨�踰덊샇
	private String title; // �젣紐�
	private String content; // �궡�슜
	private Date regdate; // �옉�꽦�씪
	private int hit; // 議고쉶�닔
	private int parent; // 湲� 洹몃９ 踰덊샇
	private int sort; // �떟湲� �젙�젹 踰덊샇
	private int tab; // �뱾�뿬 �벐湲�
	private String file;
	private int hitrank;
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int no, String id, String pwd, String title, String content, Date regdate, int hit, int parent, int sort, int tab) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.parent = parent;
		this.sort = sort;
		this.tab = tab;
	}
	
	public BoardDTO(int no, String id, String pwd, String title, String content, Date regdate, int hit, int parent, int sort, int tab, String file) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.parent = parent;
		this.sort = sort;
		this.tab = tab;
		this.file = file;
	}

	public int getHitrank() {
		return hitrank;
	}

	public void setHitrank(int hitrank) {
		this.hitrank = hitrank;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}
	
} // BoardDTO