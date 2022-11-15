/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDCARD.CARDID;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author asus
 */
@Controller
public class IDcontroller {
    @RequestMapping("/insert")
    public String getInsert(@RequestParam (value="nama" )String getNama,
                            @RequestParam (value="tanggal" )@DateTimeFormat(pattern = "yyyy-MM-dd")Date getDate,
                            @RequestParam (value="foto" )MultipartFile getFoto,                           
                            Model model)
            throws IOException{
       SimpleDateFormat tanggal = new SimpleDateFormat("EEEE,dd-MMMM-yyyy");
       String born = tanggal.format(getDate);
        
       
        String blob = Base64.encodeBase64String(getFoto.getBytes());
        String getPict ="data:image/png;base64,".concat(blob);
        model.addAttribute("sendNama",getNama);
        model.addAttribute("sendTgl",born);
        model.addAttribute("sendPict",getPict);
        
            return "view-ID";
    } 
}
