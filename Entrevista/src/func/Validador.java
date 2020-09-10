package func;

public class Validador {
	public boolean validador(String teste) {

		if (teste == null) { // proteção de null pointer
			return false;
		} else {
			while (teste.length() > 0) {
				teste = proximaRemocao(teste, 0); // remover o par mais interno da esquerda para a direita

				if (teste.length() == 0) { // Se estiver vazia significa que todos os pares foram removidos
					return true;
				} else if (teste.equals("invalida")) { // alguma invalidez já foi detectada, entrada invalida
					return false;
				}
			}
			return true; // se a entrada for vazia
		}
	}

	public String proximaRemocao(String val, int pos) {
		String[] pI = val.split(""); // utilizo uma cópia para não utilizar muita função nativa de String, como o charAt(index)
		String restantes = val;
		if (val.length() <= pos + 1) { // chegou na última posição sem encontrar seu correspondente, bem como impede um nullpointer
			return "invalida";
		} else if (val.length() > pos + 1 && abertura(pI[pos]) == fechamento(pI[pos + 1]) && abertura(pI[pos]) != -1) { 
			// chegou no próximo par mais interno e abertura casou com fechamento
			return removerPares(pI, val, pos, pos + 1);
		} else {
			restantes = proximaRemocao(restantes, pos + 1); // procura um par mais interno
			return restantes;
		}
	}

	// Remover um par de pares, utilizado pra remover um par interno da copia da string a ser validada
	public String removerPares(String[] copia, String val, int pos1, int pos2) { 
		String saida = "";
		for (int j = 0; j < val.length(); j++) {
			if (j != pos1 && j != pos2) {
				saida += copia[j];
			}
		}
		return saida;
	}
	
	// Abertura retorna um index (ou -1 caso não encontre) para formar um par interno
	public int abertura(String aberto) { 
		String estudo = "{[(";
		String[] copia = estudo.split("");
		for (int j = 0; j < estudo.length(); j++) {
			if (aberto.equals(copia[j])) {
				return j;
			}
		}
		return -1;
	}

	// Fechamento retorna um index (ou -1 caso não encontre) para formar um par interno
	public int fechamento(String fechado) {
		String estudo = "}])";
		String[] copia = estudo.split("");
		for (int j = 0; j < estudo.length(); j++) {
			if (fechado.equals(copia[j])) {
				return j;
			}
		}
		return -1;
	}
}
