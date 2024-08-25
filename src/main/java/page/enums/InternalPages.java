package page.enums;

public enum InternalPages {
  LOGIN_FORM("login-form.html");

  private final String value;

  InternalPages(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
