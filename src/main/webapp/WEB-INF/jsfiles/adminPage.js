const users = document.querySelector(".content .users");
const usersIndex = users.querySelectorAll(".user p.email");
const userName = users.querySelectorAll(".user p.userName");


////
const firstButton = document.querySelector(".all .menu-vertical .listUsers");
const secondButton = document.querySelector(".all .menu-vertical .addUsers");
const addUser = document.querySelector(".content .adduser");


let modifierBtns = document.querySelectorAll(
    ".all .content .users .user button.modifier"
);
let buttonsDellet = document.querySelectorAll(
    ".all .content .users .user .supprimer"
);

///////////////

// input info element
const user_name = document.querySelector(".content .adduser .userName");
const password = document.querySelector(".content .adduser .password");
const email = document.querySelector(".content .adduser .email");
const phone = document.querySelector(".content .adduser .address");
const surName = document.querySelector(".content .adduser .fullName");
const name = document.querySelector(".content .adduser .sexe");
const role = document.querySelector(".content .adduser .role");
const module = document.querySelector(".content .adduser .module");
//
const seccedMessage = document.querySelector(".messages .message.yes");
const fialedMessage = document.querySelector(".messages .message.no");


firstButton.addEventListener("click", function () {
    firstButton.classList.add("active");
    secondButton.classList.remove("active");
    addUser.classList.remove("active");
});



secondButton.addEventListener("click", function () {
    secondButton.classList.add("active");
    firstButton.classList.remove("active");
    addUser.classList.add("active");
    userInfo("", "", "", "", "", "", "", "", "");
});


let data = [
    <c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
        <c:if test="${!list[i].role.equals('admin')}">
            {
                email: "<c:out value="${list[i].getEmail()}"/>",
                password: "<c:out value="${list[i].getPassword()}"/>",
                role: "<c:out value="${list[i].getRole()}"/>",
                user_name: "<c:out value="${list[i].getUser_name()}"/>",
                name: "<c:out value="${list[i].getName()}"/>",
                surName: "<c:out value="${list[i].getSurname()}"/>",
                phone: "<c:out value="${list[i].getPhone()}"/>",
                module: "<c:out value="${list[i].getModule()}"/>"
            },
        </c:if>
    </c:forEach>
]


const modifierFun = (index) => {
    addUser.classList.add("active");
    userInfo(
        data[index].email,
        data[index].password,
        data[index].module,
        data[index].user_name,
        data[index].phone,
        data[index].name,
        data[index].surName,
        data[index].role,
    );
}

for (let i = 0; i < modifierBtns.length; i++) {
    modifierBtns[i].addEventListener("click", () => {
        modifierFun(i)
    })
}




const userInfo = (str1, str2, str3, str4, str5, str6, str7, str8) => {
    email.value = str1;
    password.value = str2;
    module.value = str3;
    user_name.value = str4;
    phone.value = str5;
    name.value = str6;
    surName.value = str7;
    role.value = str8;
};


