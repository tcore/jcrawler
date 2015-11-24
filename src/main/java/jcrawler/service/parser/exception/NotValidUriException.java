package jcrawler.service.parser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URI;

@AllArgsConstructor
public class NotValidUriException extends Exception {
    @Getter
    private URI uri;

    public String toString() {
        return "Not valid uri '" + uri.toString() + "'";
    }
}
