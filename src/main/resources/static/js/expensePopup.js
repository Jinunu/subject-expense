function saveFormValidator() {
// validate  사용내역, 사용일, 금액, 이미지 null 체크
    let saveForm = document.forms.saveExpense;
    let usageType = saveForm.usageType.value;
    let useDate = saveForm.useDate.value;
    let expense = saveForm.expense.value;
    let receiptImage = saveForm.receiptImage.value;

    if (!usageType) {
        alert('사용내역을 입력해 주세요...')
        return false;
    }
    if (!useDate) {
        alert('사용일자를 입력해 주세요')
        return false;
    }
    if (!expense) {
        alert('사용금액을 입력해 주세요')
        return false;
    }
    if (!receiptImage) {
        alert('영수증을 등록해 주세요')
        return false;
    }
    return true;
}