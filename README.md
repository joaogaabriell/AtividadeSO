# Atividade SO — Processamento de Pacotes de Rede

Atividade da disciplina de **Sistemas Operacionais**.

Simulação de processamento concorrente de pacotes de rede: uma fila compartilhada (`BlockingQueue`) é consumida por múltiplas threads processadoras, ilustrando concorrência e balanceamento de carga.

## Estrutura

| Classe | Descrição |
|---|---|
| `PacoteRede` | Pacote de rede imutável (id, origem, destino, tamanho) |
| `ProcessadorInterface` | Contrato do processador de pacotes |
| `Processador` | Processa pacotes simulando custo proporcional ao tamanho; contador thread-safe |
| `Main` | Cria a fila de pacotes e distribui entre 3 threads processadoras |

## Tecnologias

- Java 22
- Maven
