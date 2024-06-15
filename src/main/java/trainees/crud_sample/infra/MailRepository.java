package trainees.crud_sample.infra;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class MailRepository
  implements trainees.crud_sample.service.MailRepository {

  private JdbcClient jdbcClient;

  public MailRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public int 同じメールアドレスの登録件数を取得する(String mailAddress) {
    var sql = """
        select count(account_id) from mail where mail_address = ?
      """;
    return jdbcClient.sql(sql)
      .param(mailAddress)
      .query(Integer.class)
      .single();
  }

  @Override
  public int メールアドレスを登録する(long accountId, String mailAddress) {
    var sql = """
        INSERT INTO mail (account_id, mail_address, append_at) VALUES (?, ?, ?)
      """;
    jdbcClient.sql(sql)
      .param(accountId)
      .param(mailAddress)
      .param(LocalDateTime.now())
      .update();
    return 0;
  }
}
