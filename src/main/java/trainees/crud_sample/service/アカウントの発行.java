package trainees.crud_sample.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("NonAsciiCharacters")
@Component
@Transactional
public class アカウントの発行 {

  private AccountRepository accountRepository;
  private MailRepository mailRepository;
//  private MailRepository mailRepository;

  public アカウントの発行(AccountRepository accountRepository, MailRepository mailRepository) {
    this.accountRepository = accountRepository;
    this.mailRepository = mailRepository;
  }

  public long 発行する(String mailAddress) {
    // DBにすでにメールアドレスが登録されているかどうかを確認
    int count = mailRepository.同じメールアドレスの登録件数を取得する(mailAddress);
    if (count > 0) throw new RuntimeException("メールアドレスがすでに登録されています。");

    // 登録されていなければ、アカウントIDを発行する
    long accountId = accountRepository.アカウントIdを発行する();

    // メールアドレスを登録する
    mailRepository.メールアドレスを登録する(accountId, mailAddress);
    return accountId;
  }

}
