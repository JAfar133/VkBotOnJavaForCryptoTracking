package core.modules;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CryptoParser {
    private Element CryptoTable;

    private CryptoList cryptoList= new CryptoList();
    private ArrayList<String> cryptoArrayList = new ArrayList<>();

    public CryptoParser() throws IOException {
        CryptoTable = getPage().select("table[class=genTbl openTbl js-all-crypto-table mostActiveStockTbl crossRatesTbl allCryptoTlb wideTbl elpTbl elp15]").first();
        init();

    }
    public void init(){
        setCryptoName(getCryptoNames());
        setCryptoArrayList(getCryptoTickets());
        setCryptoPrice(getCryptoPrices());
        setCryptoChanges(getCryptoChanges());
    }
    public Elements getCryptoNames() {
        Elements names = CryptoTable.getElementsByClass("left bold elp name cryptoName first js-currency-name");
        return names;
    }
    public Elements getCryptoTickets() {
        Elements tickets = CryptoTable.getElementsByClass("left noWrap elp symb js-currency-symbol");
        return tickets;
    }
    public Elements getCryptoPrices() {
        Elements prices = CryptoTable.getElementsByClass("price js-currency-price");
        return prices;
    }
    public Elements getCryptoChanges() {
        Elements changes = CryptoTable.getElementsByAttributeValueContaining("class", "js-currency-change-24h");
        return changes;
    }

    private Document getPage() throws IOException {
        Document page;
        String url = "https://ru.investing.com/crypto/currencies";
        page = Jsoup.parse(new URL(url),10000);
        return page;
    }
    public void setCryptoName(Elements elements){
        int i = 1;
        for (Element name:elements) {
            cryptoList.addCrypto(new Crypto(i, name.text(), "", "", ""));
            i++;
        }

    }
    public void setCryptoArrayList(Elements elements){
        int i = 1;
        for (Element ticket : elements) {
            cryptoArrayList.add(ticket.text());
            cryptoList.getCrypto(i).setTiket(ticket.text());
            i++;
        }
    }public void setCryptoPrice(Elements elements){
        int i = 1;
        for (Element price : elements) {
            cryptoList.getCrypto(i).setPrice(price.text());
            i++;
        }
    }public void setCryptoChanges(Elements elements){
        int i = 1;
        for (Element change : elements) {
            cryptoList.getCrypto(i).setChanges(change.text());
            i++;
        }
    }

    public ArrayList<String> getCryptoArrayList() {
        return cryptoArrayList;
    }

    public CryptoList getCryptoList() {
        return cryptoList;
    }
}
