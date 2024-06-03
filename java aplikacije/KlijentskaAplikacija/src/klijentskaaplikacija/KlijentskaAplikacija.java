/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijentskaaplikacija;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavic
 */
public class KlijentskaAplikacija{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("*********************************************************");
            System.out.println("1. Kreiranje mesta\n"
                    + "2. Kreiranje filijale u mestu\n"
                    + "3. Kreiranje komitenta\n"
                    + "4. Promena sedišta za zadatog komitenta\n"
                    + "5. Otvaranje računa\n"
                    + "6. Zatvaranje računa\n"
                    + "7. Kreiranje transakcije koja je prenos sume sa jednog računa na drugi račun\n"
                    + "8. Kreiranje transakcije koja je uplata novca na račun\n"
                    + "9. Kreiranje transakcije koja je isplata novca sa računa\n"
                    + "10. Dohvatanje svih mesta\n"
                    + "11. Dohvatanje svih filijala\n"
                    + "12. Dohvatanje svih komitenata\n"
                    + "13. Dohvatanje svih računa za komitenta\n"
                    + "14. Dohvatanje svih transakcija za račun\n"
                    + "15. Dohvatanje svih podataka iz rezervne kopije\n"
                    + "16. Dohvatanje razlike u podacima u originalnim podacima i u rezervnoj kopiji\n");
            System.out.print("Izaberite opciju:");

            Scanner skener = new Scanner(System.in);
            String uneto = skener.nextLine();
//            System.out.println("Uneli ste " + uneto);
            try {
                int broj = Integer.parseInt(uneto);
                if (broj >= 1 && broj <= 16) {
                    System.out.println("Izabrali ste opciju broj " + broj);

                    switch (broj) {
                        case 1:
                            System.out.print("Naziv mesta:");
                            String naziv = skener.nextLine();
                            System.out.print("Postanski broj mesta:");
                            String postanskiBr = skener.nextLine();
                            System.out.println("Uneto" + naziv + "-" + postanskiBr);
                            if(naziv.isEmpty() || postanskiBr.isEmpty()){
                                System.out.println("Unesite podatke! ");
                                break;
                            }

                            String url1 = "http://localhost:8080/CentralniServer/resources/mesto/" + naziv + "/" + postanskiBr + "/" + broj;
                            System.out.println("url " + url1);

                            try {
                                HttpURLConnection httpClient = (HttpURLConnection) new URL(url1).openConnection();
                                httpClient.setRequestMethod("POST");
//                                BufferedReader reader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (new URL(urlString)).openConnection()).getInputStream(), Charset.forName("UTF-8")));

                                int responseCode = httpClient.getResponseCode();
//                                String poruka=httpClient.getResponseMessage().;
                                System.out.println("Response code:" + responseCode);

                                try (BufferedReader odgovor = new BufferedReader(new InputStreamReader(httpClient.getInputStream(), Charset.forName("UTF-8")))) {
                                    StringBuilder response = new StringBuilder();
                                    String line;
                                    while ((line = odgovor.readLine()) != null) {
                                        response.append(line);
                                    }
                                    System.out.println(response.toString());
                                }
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(KlijentskaAplikacija.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(KlijentskaAplikacija.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            break;

                        case 2:
                            System.out.println("2 to do");
                            String url2 = "http://localhost:8080/CentralniServer/resources/mesto/" ;
                            System.out.println("url " + url2);
                            try {
                                HttpURLConnection httpClient = (HttpURLConnection) new URL(url2).openConnection();
                                httpClient.setRequestMethod("POST");
//                                BufferedReader reader = new BufferedReader(new InputStreamReader(((HttpURLConnection) (new URL(urlString)).openConnection()).getInputStream(), Charset.forName("UTF-8")));

                                int responseCode = httpClient.getResponseCode();
//                                String poruka=httpClient.getResponseMessage().;
                                System.out.println("Response code:" + responseCode);

                                try (BufferedReader odgovor = new BufferedReader(new InputStreamReader(httpClient.getInputStream(), Charset.forName("UTF-8")))) {
                                    StringBuilder response = new StringBuilder();
                                    String line;
                                    while ((line = odgovor.readLine()) != null) {
                                        response.append(line);
                                    }
                                    System.out.println(response.toString());
                                }
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(KlijentskaAplikacija.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(KlijentskaAplikacija.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 3:
                            System.out.println("3 to do");
                            break;
                        case 4:
                            System.out.println("4 to do");
                            break;
                        case 5:
                            System.out.println("5 to do");
                            break;
                        case 6:
                            System.out.println("6 to do");
                            break;
                        case 7:
                            System.out.println("7 to do");
                            break;
                        case 8:
                            System.out.println("8 to do");
                            break;
                        case 9:
                            System.out.println("9 to do");
                            break;
                        case 10:
                            System.out.println("10 to do");
                            break;
                        case 11:
                            System.out.println("11 to do");
                            break;
                        case 12:
                            System.out.println("12 to do");
                            break;
                        case 13:
                            System.out.println("13 to do");
                            break;
                        case 14:
                            System.out.println("14 to do");
                            break;
                        case 15:
                            System.out.println("15 to do");
                            break;
                        case 16:
                            System.out.println("16 to do");
                            break;
                    }
                } else {
                    System.err.println("Unesite broj od 1 do 16!");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Pogresan format, unesite broj od 1 do 16!");
            }
        }
    }

}
