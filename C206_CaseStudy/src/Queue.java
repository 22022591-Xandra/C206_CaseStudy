/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Fiqriyah, 11 Aug 2023 10:03:19 am
 */

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Fiqriyah, 11 Aug 2023 10:03:19 am
 */

public class Queue {
  private String userName;
  private String itemname;
  private int qNumber;
  
  
  public Queue(String userName, String itemname, int qNumber) {
    this.userName = userName;
    this.itemname = itemname;
    this.qNumber = qNumber;
  }
  public String getUserName() {
    return userName;
  }
  public String getItemname() {
    return itemname;
  }
  public int getQNumber() {
    return qNumber;
  }
  public void setQNumber(int newQNumber) {
    qNumber = newQNumber;
  }
}
