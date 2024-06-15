package trainees.crud_sample.infra;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements
  trainees.crud_sample.service.AccountRepository {

  private JdbcClient jdbcClient;

  public AccountRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public long アカウントIdを発行する() {
    var sql = """
        INSERT INTO account DEFAULT VALUES
        returning id;
      """;
    return jdbcClient.sql(sql).query(Long.class).single();
  }

}
