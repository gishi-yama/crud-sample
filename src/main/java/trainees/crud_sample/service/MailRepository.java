package trainees.crud_sample.service;

public interface MailRepository {

  int 同じメールアドレスの登録件数を取得する(String mailAddress);

  int メールアドレスを登録する(long accountId, String mailAddress);

}
