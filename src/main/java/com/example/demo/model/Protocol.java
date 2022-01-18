package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Scanner;

@NoArgsConstructor
@Getter @Setter
public class Protocol {

    private String method;
    private String SRC;
    private String SRC_Host;
    private String DEST;
    private String DEST_Host;
    private String version;

    public Protocol(String req) {
        Scanner s = new Scanner(req);
        this.method = s.next();
        this.SRC = s.next();
        this.SRC_Host = s.next();
        this.DEST = s.next();
        this.DEST_Host = s.next();
        this.version = s.next();
    }

    public Protocol(Map<String,String> req) {
        this.method = req.get("method");
        this.SRC = req.get("SRC");
        this.SRC_Host = req.get("SRC Host");
        this.DEST = req.get("DEST");
        this.DEST_Host = req.get("DEST Host");
        this.version = req.get("version");
    }

    @Override
    public String toString() {
        return method + ' ' +
                " " + SRC +
                " " + SRC_Host +
                " " + DEST +
                " " + DEST_Host +
                " " + version + "\r\n";
    }


}
