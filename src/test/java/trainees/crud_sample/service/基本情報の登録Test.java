package trainees.crud_sample.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class 基本情報の登録Test {

  @Autowired
  private 基本情報の登録 sut;

  @Test
  void メールアドレス渡して登録すると登録完了情報を返す() {
    var actual = sut.登録する("yamakawa@photon.chitose.ac.jp");
    assertThat(actual).isEqualTo(
      new 基本情報の登録.登録完了情報(1L, "yamakawa@photon.chitose.ac.jp"));
  }
}