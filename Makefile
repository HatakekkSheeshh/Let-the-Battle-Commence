src=source/*.java
src+=util/*.java
src+=class/*.java
src+=unit_test/*.java
RUN = bin;class

# Copy existing .class files to bin
# @: dont show command while compiling
# /Y - dont ask when overriding file
# Compile new .java files
# -cp (classpath): to find file.class to compile
# -d (destination directory): make this folder to save file .class

# prepare compile copy
all:
	@javac -d bin ${src}
# Run from bin directory
play:
	@java -cp "${RUN}" Main
test:
	@java -cp "${RUN}" TestFighters
# Clean bin directory
clean:
	@rm -rf bin