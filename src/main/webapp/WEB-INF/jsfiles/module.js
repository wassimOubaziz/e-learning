const editBtns = document.querySelectorAll("tbody tr .modifier");
let data = [
    <c:forEach items="${ info }" var="info">
        {
            moduleName: "<c:out value="${info.getModuleName()}"/>",
            week: "<c:out value="${info.getWeek()}"/>",
            type: "<c:out value="${info.getType()}"/>",
            file: "<c:out value="${info.getFile()}"/>",
            pdfName: "<c:out value="${info.getPdfName()}"/>",
            period: "<c:out value="${info.getPeriod()}"/>"
        },
    </c:forEach>
]

editBtns.forEach((editBtn, index) => {
    editBtn.addEventListener("click", () => {
        console.log(data[index])
        editInputs(data[index].week, data[index].type, data[index].file, data[index].pdfName, data[index].period);
    })
})

//////
const week = document.querySelector(".inp.week");
const type = document.querySelector(".typek");
const file = document.querySelector(".inp.file");
const pdfName = document.querySelector(".inp.pdfName");
const period = document.querySelector(".inp.period");


let editInputs = (str1, str2, str3, str4, str5) => {
    week.value = str1;
    type.value = str2;
    file.value = str3;
    pdfName.value = str4;
    period.value = str5;
    week.readOnly = true;
    pdfName.readOnly = true;
    week.style.opacity = 0.6;
    type.style.opacity = 0.6;
    pdfName.style.opacity = 0.6;
}






