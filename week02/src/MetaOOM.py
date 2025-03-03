num_classes = 50000

with open("MetaspaceOverflow.java", "w", encoding="utf-8") as f:
    f.write("public class MetaspaceOverflow {\n")
    f.write("    public static void main(String[] args) {\n")
    f.write(f"        for (int i = 0; i < {num_classes}; i++) {{\n")
    f.write("            try {\n")
    f.write("                Class.forName(\"Class_\" + i);\n")
    f.write("            } catch (ClassNotFoundException e) {\n")
    f.write("                e.printStackTrace();\n")
    f.write("            }\n")
    f.write("        }\n")
    f.write("    }\n")
    f.write("}\n\n")

    for i in range(num_classes):
        f.write(f"class Class_{i} {{\n")
        f.write("    private static Object obj = new Object();\n")
        f.write("    public static void method() {}\n")
        f.write("}\n\n")