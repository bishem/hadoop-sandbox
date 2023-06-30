package fr.diginamic.hadoop.playground.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.diginamic.hadoop.playground.service.WebHDFSClient;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HadoopRunner implements CommandLineRunner {

  private final WebHDFSClient client;

  @Override
  public void run(final String... args) throws Exception {
    client.open("/workspace/genome-tags.csv").get().subscribe(client::print);
  }
}