package com.project.secondhand.vo;

public class StoreBoardPic {
	private int boardPic;
	private String boardPicName;
	private String boardSize;
	private String boardExt;
	public int getBoardPic() {
		return boardPic;
	}
	public void setBoardPic(int boardPic) {
		this.boardPic = boardPic;
	}
	public String getBoardPicName() {
		return boardPicName;
	}
	public void setBoardPicName(String boardPicName) {
		this.boardPicName = boardPicName;
	}
	public String getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(String boardSize) {
		this.boardSize = boardSize;
	}
	public String getBoardExt() {
		return boardExt;
	}
	public void setBoardExt(String boardExt) {
		this.boardExt = boardExt;
	}
	@Override
	public String toString() {
		return "StoreBoardPic [boardPic=" + boardPic + ", boardPicName=" + boardPicName + ", boardSize=" + boardSize
				+ ", boardExt=" + boardExt + "]";
	}
	

}
