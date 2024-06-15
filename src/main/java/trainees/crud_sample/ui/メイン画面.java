package trainees.crud_sample.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import trainees.crud_sample.service.基本情報の登録;

@Route("/")
public class メイン画面 extends VerticalLayout {


  @Autowired
  private 基本情報の登録 基本情報の登録;

  public メイン画面() {

    EmailField field = new EmailField();
    field.setLabel("メールアドレス");
    field.getElement().setAttribute("name", "email");
    field.setErrorMessage("有効なメールアドレスを入力してください。");
    field.setClearButtonVisible(true);
    field.setRequired(true);
    field.setPrefixComponent(VaadinIcon.ENVELOPE.create());
    add(field);

    Button primaryButton = new Button("登録");
    primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    add(primaryButton);

    field.addValueChangeListener(event -> {
      primaryButton.setEnabled(!field.isInvalid());
    });

    primaryButton.addClickListener(clickEvent -> {
      基本情報の登録.登録完了情報 result = 基本情報の登録.登録する(field.getValue());
      add(new Text("登録完了: " + result.accountId() + " " + result.mailAddress()));
    });


  }

}