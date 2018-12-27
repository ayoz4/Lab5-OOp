package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller
{
    private CreateGood createGood;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Pane goodTextAreaPane;

    @FXML
    private TextArea goodTextArea;

    @FXML
    private URL location;

    @FXML
    private TextField goodName;

    @FXML
    private Pane goodPane;

    @FXML
    private DatePicker goodDeliveryDate;

    @FXML
    private TextField goodPrice;

    @FXML
    private TextField goodNumber;

    @FXML
    void openGood(ActionEvent event)
    {
        hidePanes(false, true);
        goodNumber.clear();
        goodPrice.clear();
        goodNumber.clear();
    }

    @FXML
    void addGood(ActionEvent event)
    {
        boolean error = true;
        int serianNumber = 0, price = 0;
        if (goodName.getText().equals(""))
        {
            error = false;
            System.out.println("error1");
        }
        if (error)
        {
            try
            {
                price = Integer.parseInt(goodPrice.getText());
            }
            catch (Exception e)
            {
                error = false;
                System.out.println("error2");
            }
        }
        if (error)
        {
            if (goodDeliveryDate.getValue() == null)
            {
                error = false;
            }
        }
        if (error)
        {
            try
            {
                serianNumber = Integer.parseInt(goodNumber.getText());
            }
            catch (Exception e)
            {
                error = false;
                System.out.println("error3");
            }
        }
        if (error)                  //Реализация прототипа
        {
            createGood = CreateGood.checkClass();
            System.out.println(createGood.getGoods().size());
            if (createGood.getGoods().isEmpty())
            {
                createGood.createGood(createGood.getGoods(), goodName.getText(), price, goodDeliveryDate.getValue(), serianNumber);
            }
            else
            {
                System.out.println("Obeject already exists!");
                createGood.CloneGood(createGood.getGoods(), goodName.getText(), price, goodDeliveryDate.getValue(), serianNumber);
            }
            System.out.println(createGood.getGoods().size());
            System.out.println("Товар добавлен");
            hidePanes(true, true);
        }
    }

    @FXML
    void initialize() {
        assert goodName != null : "fx:id=\"goodName\" was not injected: check your FXML file 'sample.fxml'.";
        assert goodPane != null : "fx:id=\"goodPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert goodDeliveryDate != null : "fx:id=\"goodDeliveryDate\" was not injected: check your FXML file 'sample.fxml'.";
        assert goodPrice != null : "fx:id=\"goodPrice\" was not injected: check your FXML file 'sample.fxml'.";
        assert goodNumber != null : "fx:id=\"goodNumber\" was not injected: check your FXML file 'sample.fxml'.";

    }

    public void hidePanes(boolean goodPane, boolean goodTextArea)
    {
        if (goodPane)
            this.goodPane.setVisible(false);
        else
            this.goodPane.setVisible(true);
        if (goodTextArea)
            this.goodTextAreaPane.setVisible(false);
        else
            this.goodTextAreaPane.setVisible(true);
    }

    @FXML
    void openGoodTextArea(ActionEvent event)
    {
        createGood = CreateGood.checkClass();
        hidePanes(true, false);
        goodTextArea.clear();
        for (int i = 0; i < createGood.getGoods().size(); i++)
        {
            goodTextArea.appendText("========================\n");
            goodTextArea.appendText("Наименование товара: " + createGood.getGoods().get(i).getName() + "\n");
            goodTextArea.appendText("Цена товара: " + createGood.getGoods().get(i).getPrice() + "\n");
            goodTextArea.appendText("Дата доставки товара: " + createGood.getGoods().get(i).getDeliveryDate() + "\n");
            goodTextArea.appendText("Серийный номер товара: " + createGood.getGoods().get(i).getNumber() + "\n");
        }
    }
}

