function getName() {
    var name = this.name;
    if (name.equals("苹果"))
        "<%request.setAttribute(\"name\",\"苹果\");%>";
    else if (name.equals("手机"))
        "<%request.setAttribute(\"name\",\"手机\");%>";
    else if (name.equals("电脑"))
        "<%request.setAttribute(\"name\",\"电脑\");%>";
    else
        "<%request.setAttribute(\"name\",\"电视\");%>";
    alert(name);
    submit();
}