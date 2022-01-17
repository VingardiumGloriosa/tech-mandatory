package com.techman.techmandatory2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        this.version = s.nextLine();
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
