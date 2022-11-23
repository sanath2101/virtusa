function clearPreviousDiv()
{
    var right = document.getElementsByClassName("childComp");
    Array.from(right).forEach(element => {
        element.style.display = "none";
    });
}
function createAcount()
{
    clearPreviousDiv();
    document.getElementById("createAccount").style.display = "block";
}
function deleteAccount()
{
    clearPreviousDiv();
    document.getElementById("deleteAccount").style.display = "block";
}
function updateAccount()
{
    clearPreviousDiv();
    document.getElementById("updateAccount").style.display = "block";
}
function displayAccount()
{
    clearPreviousDiv();
    document.getElementById("displayAccount").style.display = "block";
}
function depositAmount()
{
    clearPreviousDiv();
    document.getElementById("depositAmount").style.display = "block";
}
function withDraw()
{
    clearPreviousDiv();
    document.getElementById("withDraw").style.display = "block";
}
function transferFunds()
{
    clearPreviousDiv();
    document.getElementById("transferFunds").style.display = "block";
}