package io.github.patfromthe90s.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.patfromthe90s.global.GlobalTest;
import io.github.patfromthe90s.model.Article;

public class NHKEasyArticleParserTest extends GlobalTest {
	
	private static final String EXAMPLE_ARTICLE_HTML;
	private static final String EXAMPLE_ARTICLE_DATA = "東南アジアの１０の国でつくるＡＳＥＡＮの会議が２３日、タイのバンコクでありました。会議のあと、タイのプラユット首相は「１０の国で一緒に２０３４年のサッカーのワールドカップを開きたいと思います。この夢を本当のことにしましょう」と言いました。ＡＳＥＡＮの国では、サッカーがいちばん強いベトナムでも、世界のランキングで９６番目です。東南アジアのサッカーはこれから強くなるところですが、人気があるスポーツの１つです。東南アジアでサッカーのワールドカップを開くことになると、初めてのことになります。";
	
	// Load test HTML from file. Not modified, so only needs to be done once.
	static {
		StringBuilder sb = new StringBuilder();
		InputStream is = NHKEasyArticleParserTest.class.getClassLoader().getResourceAsStream("example-article.html");
		try (Scanner scanner = new Scanner(is, "UTF-8")) {
			while (scanner.hasNextLine())
				sb.append(scanner.nextLine());
		}
		
		EXAMPLE_ARTICLE_HTML = sb.toString();
	}
	
	private ArticleParser parser;
	
	@BeforeEach
	public void setup() {
		parser = new NHKEasyArticleParser();
	}
	
	@Test
	@DisplayName("When given a HTML page, then parsed correctly and data added to Article")
	public void whenGivenHtml_thenDataAddedToArticle() {
		Article article = Article.create();
		Article parsedArticle = parser.parse(article, EXAMPLE_ARTICLE_HTML);
		assertEquals(EXAMPLE_ARTICLE_DATA, parsedArticle.getData());
	}

}
