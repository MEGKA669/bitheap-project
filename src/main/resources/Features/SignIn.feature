Feature: Authentification sur le site Bitheap
  Scenario: Authentification avec un compte valide
    Given utilisateur doit se trouver sur le site Bitheap
    When utilisateur clique sur le bouton login (sur la page d'accueil)
    And utilisateur saisit le username et le mot de passe
    And utilisateur clique sur le bouton login (sur la page de connexion)
    Then utilisateur est connecté sur le site

    Scenario: ajouter un produit dans le panier
      Given utilisateur doit se trouver sur le site Bitheap
      And utilisateur est connecté sur le site
      When utilisateur clique sur le bouton shop
      And utilisateur ajoute un produit dans le panier
      Then le panier est mis a jour avec le nouveau article


