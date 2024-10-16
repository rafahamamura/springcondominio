package br.unesp.springcondominio.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

   @GetMapping("/")
   public String returnServerAddress() {
      try {
         return "Acesso de " + InetAddress.getLocalHost().getHostAddress();
      } catch (UnknownHostException uhe) {
         System.err.println(uhe);
         return uhe.toString();
      }
   }
}
