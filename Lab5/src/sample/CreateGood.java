package sample;

import java.time.LocalDate;
import java.util.ArrayList;


//Singleton
public class CreateGood
{
    private ArrayList<Goods> goodsArrayList;

    private static CreateGood createGood;

    private CreateGood()
    {
        this.goodsArrayList = new ArrayList<>();
    }

    public void addGood(Goods goods)
    {
        goodsArrayList.add(goods);
    }

    public ArrayList<Goods> getGoods()
    {
        return goodsArrayList;
    }

    public void createGood(ArrayList<Goods> goodsArrayList, String name, int price, LocalDate deliveryDate, int number)
    {
        Goods goods = new Goods(name, price, deliveryDate, number);
        goodsArrayList.add(goods);
    }

    public void CloneGood(ArrayList<Goods> goodsArrayList, String name, int price, LocalDate deliveryDate, int number)
    {
        Goods goods = goodsArrayList.get(0).clone();
        goods.setName(name);
        goods.setPrice(price);
        goods.setDeliveryDate(deliveryDate);
        goods.setNumber(number);
        goodsArrayList.add(goods);
    }

    public static CreateGood checkClass()
    {
        if (createGood == null)
            createGood = new CreateGood();
        else
            System.out.println("Object of this class already exists!");
        return createGood;
    }
}
