# Kontrola zmian przed commitem

Przed zapisaniem zmian sprawdź status oraz różnice w plikach:

```bash
git status --short
git diff --stat
git diff
```

`git diff` pokazuje zmiany, które nie trafiły jeszcze do staging area.

Dodaj wybrane pliki, a potem sprawdź dokładnie to, co zapisze commit:

```bash
git add README.md docs/git-checks.md
git diff --cached --stat
git diff --cached --check
git diff --cached
```

- `--cached --stat` pokazuje podsumowanie przygotowanych zmian.
- `--cached --check` wykrywa między innymi zbędne spacje na końcach linii.
- `--cached` pokazuje pełną treść przygotowanych zmian.

Po poprawieniu znalezionych problemów ponownie dodaj zmienione pliki do staging area.

## Usunięcie pliku ze stagingu

```bash
git restore --staged docs/git-checks.md
```

To polecenie usuwa plik ze staging area i pozostawia jego zmiany w katalogu roboczym.
