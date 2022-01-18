package com.techman.techmandatory2.model;

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

    public Protocol(Protocol protocol) {
        this.method = protocol.getMethod();
        this.SRC = protocol.getSRC();
        this.SRC_Host = protocol.getSRC_Host();
        this.DEST = protocol.getDEST();
        this.DEST_Host = protocol.getDEST_Host();
        this.version = protocol.getVersion();
    }

    public Protocol(Map<String,String> req) {
        this.method = req.get("method");
        this.SRC = req.get("SRC");
        this.SRC_Host = req.get("SRC_Host");
        this.DEST = req.get("DEST");
        this.DEST_Host = req.get("DEST_Host");
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
