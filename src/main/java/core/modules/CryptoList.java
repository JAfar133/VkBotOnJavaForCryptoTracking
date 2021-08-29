package core.modules;

import java.util.ArrayList;

public class CryptoList {
    private ArrayList<Crypto> list = new ArrayList<>();
    public CryptoList() {
        list = new ArrayList<Crypto>();
    }

    public ArrayList<Crypto> getList() {
        return list;
    }

    public boolean addCrypto(Crypto cp){
        if(list.add(cp))
            return true;
        else
            return false;
    }
    public boolean delCrypto(Crypto cp){
        if(list.remove(cp))
            return true;
        else
            return false;
    }
    public Crypto getCrypto(int id){
        for (Crypto cp:list)
            if(cp.getId()==id)return cp;
        return null;
    }
    public Crypto getCrypto(String ticket){
        for (Crypto cp:list)
            if(cp.getTiket().equals(ticket))return cp;
        return null;
    }
    public void putCrypto(){
        int i = 1;
        for (Crypto sp:list) {
            System.out.printf("%7d%20s%30s%40s\n",
                    sp.getId(), sp.getName(), sp.getTiket(), sp.getPrice());
            i++;
        }
        System.out.println();
    }

}
