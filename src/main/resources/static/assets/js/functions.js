function showModalAguarde() {
    var modalLoading = '\
			<div class="modal" id="modalAguarde" data-backdrop="static" data-keyboard="false" role="dialog">\
			\
			    <div class="text-center" style="position: absolute;left: 45%; top: 50%; transform: translateY(-50%); margin:0;">\
		 	   	\
		   		 	<div class="lds-ellipsis"><div>\
		    		<p style="color: white;">Processando.. Aguarde..</p></div>\
		   		\
		     	</div>\
		    \
			</div>';
    $(document.body).append(modalLoading);
    $("#modalAguarde").modal("show");
}

function hideModalAguarde() {
    $("#modalAguarde").modal("hide");
}

function abrirModal(txModal) {
    $("#" + txModal).modal("show");
}

function ocultarModal(txModal) {
    $("#" + txModal).modal("hide");
}

function loadPage(div, txEndPoint){
    $("#" + div).load(txEndPoint);
}

function gravarModalCadastro(idModal, idForm, urlDestino, idTable) {
    //showModalAguarde();
    var formItens = new FormData(document.getElementById(idForm));

    $.ajax({
        type: "POST",
        url: urlDestino,
        data: formItens,
        processData: false,
        contentType: false,
        success: function (data) {
            if(data[0]["cdStatus"] == 1) {
                ocultarModal(idModal);
                loadPage(idTable, data[0]["txEndPointRetorno"]);
                //hideModalAguarde();
            }
        }
    })

}