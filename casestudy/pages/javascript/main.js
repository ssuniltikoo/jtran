function clearAllFields(){
    var allElements  = document.getElementsByTagName("input");
    allElements.array.forEach(element => {
        element.getElementsByTagName.innertext="";
    });

    for(var i = 0 ; i<allElements.length;i++){
        allElements[i].innerText="";
    }
}






