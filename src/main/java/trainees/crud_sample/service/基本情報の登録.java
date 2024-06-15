package trainees.crud_sample.service;

import org.springframework.stereotype.Service;


@Service
public class 基本情報の登録 {

  private アカウントの発行 アカウントの発行;

  public 基本情報の登録(アカウントの発行 アカウントIDの発行) {
    this.アカウントの発行 = アカウントIDの発行;
  }

  public 登録完了情報 登録する(String mailAddress) {
    // ここに基本情報の登録処理を書く
    long accountId = アカウントの発行.発行する(mailAddress);

    return new 登録完了情報(accountId, mailAddress);
  }

  public record 登録完了情報(long accountId, String mailAddress) {
  }

}
