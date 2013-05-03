BIN = ./bin
SRC = ./src
HTML = ./html
PROP = ./properties
JDBC = ./jar/jdbc4.jar

all : create_bin
	javac -encoding UTF-8 \
	-d $(BIN) \
	-classpath $(SRC):$(JDBC) \
	$(SRC)/gui/Main.java

create_bin :
	mkdir -p $(BIN)

javadoc : create_html
	javadoc \
	-docencoding UTF-8 -charset UTF-8 \
	-d $(HTML) \
	-sourcepath $(SRC) \
	-classpath $(JDBC) \
	 gui utils panels frames listeners

create_html :
	mkdir -p $(HTML)

clean :
	rm -rf $(BIN) $(HTML)

exec :
	java -cp $(BIN):$(PROP):$(JDBC) gui.Main
